<template>
  <div class="app-container">
    <header><h1>KampungKaki</h1></header>
    <p>Description</p>

    <main class="dashboard">
      <aside class="sidebar">
        <ItemForm :categories="categories" @post-item="handlePost" />
      </aside>

      <section class="content">
        <ItemFilter 
          v-model:searchQuery="searchQuery" 
          v-model:selectedCategory="selectedCategory" 
          :categories="categories" 
        />

        <div class="feed-grid">
          <ItemCard 
            v-for="item in filteredItems" :key="item.id" 
            :item="item"
            @toggle="handleToggle"
            @remove="removeItem"
          />
        </div>
      </section>
    </main>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from 'vue';
import { getItems, createItem, deleteItem, toggleItemStatus } from './api';

// Import Components
import ItemForm from './components/ItemForm.vue';
import ItemFilter from './components/ItemFilter.vue';
import ItemCard from './components/ItemCard.vue';

// State & Logic
const items = ref([]);
const searchQuery = ref('');
const selectedCategory = ref('All');
const categories = ['General', 'Tools', 'Kitchen', 'Food', 'Electronics', 'Books'];

const filteredItems = computed(() => {
  return items.value.filter(item => {
    const matchesSearch = item.title.toLowerCase().includes(searchQuery.value.toLowerCase());
    const matchesCategory = selectedCategory.value === 'All' || item.category === selectedCategory.value;
    return matchesSearch && matchesCategory;
  });
});

const refreshFeed = async () => {
  const response = await getItems();
  items.value = response.data;
};

const handlePost = async (newItemData) => {
  await createItem(newItemData);
  refreshFeed();
};

const handleToggle = async (id) => {
  await toggleItemStatus(id);
  refreshFeed();
};

const removeItem = async (id) => {
  if (confirm("Delete this listing?")) {
    await deleteItem(id);
    refreshFeed();
  }
};

onMounted(refreshFeed);
</script>

<style>
/* Global Styles */
body { background-color: #f8fafc; margin: 0; }

.app-container { 
  max-width: 1400px; 
  margin: 0 auto; 
  padding: 40px 20px;
  font-family: 'Inter', sans-serif;
}

.dashboard {
  display: grid;
  grid-template-columns: 350px 1fr;
  gap: 40px;
  align-items: start;
}

.sidebar {
  position: sticky;
  top: 20px;
}

.feed-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
  gap: 20px;
}

@media (max-width: 900px) {
  .dashboard { grid-template-columns: 1fr; }
}
</style>

