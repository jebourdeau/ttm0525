import React, { useEffect, useState } from 'react';
import { getAllUsers } from '../../services/userService';

export const UserList = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        const fetchUsers = async () => {
        try {
            const usersData = await getAllUsers();
            setUsers(usersData);
        } catch (error) {
            console.error('Error fetching users:', error);
        }
        };

        fetchUsers();
    }, []);

    return (
        <div>
        <h2>Liste des utilisateurs</h2>
        <ul>
            {users.map(user => (
            <li key={user.id}>
                {user.username} - {user.age} ans - {user.role} - {user.project}-{user.password}
            </li>
            ))}
        </ul>
        </div>
    );
};
