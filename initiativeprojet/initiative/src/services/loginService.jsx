import { apiRequest } from './apiService';

export async function loginService(username, password) {
  return apiRequest('/api/loginuser', {
    method: 'POST',
    body: JSON.stringify({ username, password })
  });
};

export async function registerService(username, password) {
  return apiRequest('/api/registeruser', {
    method: 'POST',
    body: JSON.stringify({ username, password })
  });
};
// export default loginService;
// export default registerService;
