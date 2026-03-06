<template>
  <div class="browser-controls">
    <input :value="searchQuery" @input="$emit('update:searchQuery', $event.target.value)" 
           placeholder="Search items..." class="search-bar" />
    
    <div class="filter-bar">
      <button v-for="cat in ['All', ...categories]" :key="cat"
        @click="$emit('update:selectedCategory', cat)"
        :class="{ 'active-filter': selectedCategory === cat }" class="filter-pill">
        {{ cat }}
      </button>
    </div>
  </div>
</template>

<script setup>
defineProps(['searchQuery', 'selectedCategory', 'categories']);
defineEmits(['update:searchQuery', 'update:selectedCategory']);
</script>

<style scoped>
.browser-controls { margin-bottom: 25px; }

.search-bar { 
  width: 100%;
  padding: 12px;
  border-radius: 8px;
  font-size: 1.1rem; 
  border: 2px solid #e2e8f0; 
  margin-bottom: 15px;
  background: white;
}

.filter-bar { display: flex; gap: 10px; flex-wrap: wrap; margin-bottom: 10px; }

.filter-pill {
  padding: 8px 18px;
  border-radius: 99px;
  background: #e2e8f0;
  color: #475569;
  border: none;
  cursor: pointer;
  font-weight: 500;
  transition: all 0.2s;
}

.active-filter { background: #2563eb; color: white; }
</style>