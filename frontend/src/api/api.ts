import axios from 'axios';

const API_BASE_URL: string = 'http://localhost:8080/api/v1';

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


export const getTest = async (): Promise<void> => {
  const response = await apiClient.get<void>(`/test`);
  return response.data;
};

