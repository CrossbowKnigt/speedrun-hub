import axios from 'axios';
import type { Marathon } from '../types/Marathon';

const API_BASE_URL: string = 'http://localhost:8080/api/';

export const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
  auth: {
    username: 'user',
    password: 'password'
  },
});


export const getMarathons = async (): Promise<Marathon[]> => {
  const response = await apiClient.get<Marathon[]>(`/marathons`);
  return response.data;
};

