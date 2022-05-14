import axios from 'axios';

const service = axios.create({
  baseURL: 'http://localhost:8080/api/v1',
  headers: { 'content-type': 'application/json' },
  timeout: 9000,
});

service.interceptors.request.use(
  (config) => {
    return config;
  },
  (error) => {
    return Promise.reject(error);
  },
);

service.interceptors.response.use(
  (response) => {
    return response['data'];
  },
  (error) => {
    return Promise.reject(error);
  },
);

export default service;
