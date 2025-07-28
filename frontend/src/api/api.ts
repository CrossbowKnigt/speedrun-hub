import axios from 'axios';
import type { Marathon } from '../types/Marathon';
import type { MarathonPost } from '../types/MarathonPost';

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


export const createMarathon = async (marathonPost : MarathonPost): Promise<Marathon> => {
  const response = await apiClient.post<Marathon>('/marathons', marathonPost);
  return response.data;
}
