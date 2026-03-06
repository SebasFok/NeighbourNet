import axios from 'axios';

const API_URL = 'http://localhost:8080/api/items';

export const getItems = () => axios.get(API_URL);
export const createItem = (item) => axios.post(API_URL, item);
export const toggleItemStatus = (id) => axios.patch(`${API_URL}/${id}/toggle`);
export const deleteItem = (id) => axios.delete(`${API_URL}/${id}`);