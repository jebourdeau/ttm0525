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

    const register = async (username, password) => {
        try {
        const data = await loginService.register(username, password);
        setAuth(data);
        return true;
        } catch (error) {
        console.error('Registration error:', error);
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
