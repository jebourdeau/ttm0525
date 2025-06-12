import { createContext, useContext, useState } from 'react';
import { jwtDecode } from '../services/jwt';
import { loginService } from '../services/loginService';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
    const [auth, setAuth] = useState(null);

    const login = async (username, password) => {
        try {
        const data = await loginService(username, password);
        const userInfo = jwtDecode(data.accessToken);
        setAuth(userInfo);
        return data;
        } catch (error) {
        console.error('Login failed:', error);
        throw error;
        }
    };
    const register = async (username, password, email, role, age) => {
        try {
            const response = await fetch('http://localhost:8080/auth/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password, email, role, age }),
            });
            if (!response.ok) return false;
            const data = await response.json();
            setAuth(jwtDecode(data.accessToken));
            return true;
        } catch (error) {
            console.error('Erreur lors de l’inscription :', error);
            return false;
        }
    };

    const logout = () => {
        setAuth(null);
    };

    return (
        <AuthContext.Provider value={{ auth, login, register, logout }}>
        {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
export { AuthContext };
