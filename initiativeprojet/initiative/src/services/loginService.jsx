import { apiRequest } from './apiService';

export async function loginService(username, password) {
  return apiRequest('/auth/login', {
    method: 'POST',
    body: JSON.stringify({ username, password })
  });
};

export async function registerService(username, password) {
  return apiRequest('/auth/register', {
    method: 'POST',
    body: JSON.stringify({ username, password })
  });
};
// export default loginService;
// export default registerService;
