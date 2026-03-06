<template>
  <section class="form-card">
    <h3>Post an Item to Share</h3>
    <div class="input-group" v-for="field in fields" :key="field.label">
      <label>{{ field.label }}</label>
      <input v-if="field.type === 'text'" v-model="localItem[field.model]" :placeholder="field.placeholder" />
      <select v-else v-model="localItem[field.model]" class="category-select">
        <option v-for="cat in categories" :key="cat" :value="cat">{{ cat }}</option>
      </select>
    </div>
    <button @click="submit" class="post-btn" :disabled="!isFormValid">List My Item</button>
  </section>
</template>

<script setup>
import { ref, computed } from 'vue';
const props = defineProps(['categories']);
const emit = defineEmits(['post-item']);


const fields = [
  { label: 'Item Name', model: 'title', type: 'text', placeholder: 'e.g. Power Drill' },
  { label: 'Category', model: 'category', type: 'select' },
  { label: 'Description', model: 'description', type: 'text', placeholder: 'Short details' },
  { label: 'Telegram Handle', model: 'contact', type: 'text', placeholder: '@yourname' }
];

const isFormValid = computed(() => {
  return localItem.value.title.trim() && localItem.value.contact.trim();
});

const localItem = ref({ title: '', description: '', contact: '', category: 'General' });

const submit = () => {
  emit('post-item', { ...localItem.value });
  localItem.value = { title: '', description: '', contact: '', category: 'General' };
};
</script>

<style scoped>
.form-card {
  background: white;
  padding: 24px;
  border-radius: 16px;
  box-shadow: 0 4px 6px -1px rgba(0,0,0,0.1);
}

.input-group { margin-bottom: 15px; }
.input-group label { display: block; font-size: 0.85rem; font-weight: 600; color: #64748b; margin-bottom: 5px; }

input {
  width: 90%;
  padding: 12px;
  border: 1px solid #e2e8f0;
  border-radius: 8px;
  background: #fdfdfd;
}

.category-select {
  width: 100%;
  padding: 12px;
  border: 1px solid #e2e8f0;
  border-radius: 8px;
  background: #fdfdfd;
}

.post-btn {
  width: 100%;
  padding: 14px;
  background: #2563eb;
  color: white;
  border: none;
  border-radius: 8px;
  font-weight: bold;
  cursor: pointer;
  transition: background 0.2s;
}

.post-btn:hover { background: #1d4ed8; }

.post-btn:disabled {
  background: #94a3b8;
  cursor: not-allowed;
}
</style>