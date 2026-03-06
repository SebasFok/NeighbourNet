<template>
  <div class="item-card" :class="[item.category.toLowerCase(), { 'unavailable': !item.available }]">
    <div class="card-header">
      <span class="category-tag">{{ item.category }}</span>
      <span class="availability-dot" :class="{ 'is-busy': !item.available }"></span>
    </div>
    <div class="item-info">
      <h4 :class="{ 'strikethrough': !item.available }">{{ item.title }}</h4>
      <p class="description">{{ item.description }}</p>
      <div class="badge">Contact: {{ item.contact }}</div>
    </div>
    <div class="item-actions">
      <button @click="$emit('toggle', item.id)" class="status-btn">
        {{ item.available ? 'Loan' : 'Return' }}
      </button>
      <button @click="$emit('remove', item.id)" class="delete-btn">Remove</button>
    </div>
  </div>
</template>

<script setup>
defineProps(['item']);
defineEmits(['toggle', 'remove']);
</script>

<style scoped>
.item-card {
  background: white;
  padding: 24px;
  border-radius: 20px;
  border-left: 6px solid #94a3b8;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  transition: transform 0.2s;
}
.item-card:hover { transform: translateY(-4px); }

/* Category Border Logic */
.item-card.tools { border-left-color: #475569; }
.item-card.kitchen { border-left-color: #f97316; }
.item-card.food { border-left-color: #ef4444; }
.item-card.electronics { border-left-color: #3b82f6; }
.item-card.books { border-left-color: #a855f7; }
.item-card.general { border-left-color: #10b981; }

.card-header { display: flex; justify-content: space-between; margin-bottom: 10px; }
.category-tag { font-size: 0.7rem; font-weight: 800; text-transform: uppercase; color: #94a3b8; }

.availability-dot { width: 10px; height: 10px; background: #22c55e; border-radius: 50%; }
.is-busy { background: #ef4444; }

.item-info h4 { margin: 5px 0; font-size: 1.25rem; }
.description { color: #64748b; font-size: 0.95rem; margin-bottom: 15px; }
.strikethrough { text-decoration: line-through; color: #cbd5e0; }

.badge { background: #f1f5f9; padding: 6px 12px; border-radius: 6px; font-size: 0.85rem; display: inline-block; }

.item-actions { margin-top: 20px; display: flex; gap: 10px; }
.status-btn, .delete-btn { 
  flex: 1; 
  padding: 8px; 
  border-radius: 6px; 
  border: none; 
  cursor: pointer; 
  font-weight: 600;
}

.status-btn { background: #f1f5f9; color: #475569; }
.delete-btn { background: #fee2e2; color: #ef4444; }

.unavailable { background: #f8fafc; opacity: 0.8; }
</style>