import React, { createContext, useState, useContext } from 'react';
import { loginService } from '../services/loginService';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
    const [auth, setAuth] = useState(null);

    const login = async (username, password) => {
        try {
        const data = await loginService.login(username, password);
        setAuth(data);
        return data;
        } catch (error) {
        console.error('Login failed:', error);
        throw error;
        }
    };
    const register = async (username, password, role) => {
        try {
            const response = await fetch('http://localhost:8080/users', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password, role }),
            });

            if (!response.ok) return false;

            const data = await response.json();
            setAuth(data);
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
export { AuthContext};