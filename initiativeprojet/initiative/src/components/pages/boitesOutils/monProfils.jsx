import React, { useState, useEffect } from 'react';
import '../../../styles/profils.css';

const MonProfils = () => {
  const [user, setUser] = useState({
    id: '',
    username: '',
    email: '',
    age: '',
    password: '',
    role: '',
    projet: '',
  });

  useEffect(() => {
    // Récupère l'utilisateur connecté (à adapter selon ton système d'authentification)
    const fetchUser = async () => {
      try {
        const res = await fetch('http://localhost:8080/users/me', {
          credentials: 'include',
        });
        const data = await res.json();
        setUser(data);
      } catch (error) {
        console.error('Erreur de chargement du profil :', error);
      }
    };

    fetchUser();
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUser((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
      const res = await fetch(`http://localhost:8080/users/${user.id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(user),
      });

      if (res.ok) {
        alert('Profil mis à jour avec succès !');
      } else {
        alert('Erreur lors de la mise à jour du profil.');
      }
  
  };

  return (
    <form onSubmit={handleSubmit} className="mon-profil-form">
      <div>
        <label>Nom d'utilisateur :</label>
        <input type="text" name="username" value={user.username} onChange={handleChange} required />
      </div>
      <div>
        <label>Email :</label>
        <input type="email" name="email" value={user.email} onChange={handleChange} required />
      </div>
      <div>
        <label>Âge :</label>
        <input type="number" name="age" value={user.age} onChange={handleChange} required />
      </div>
      <div>
        <label>Mot de passe :</label>
        <input type="password" name="password" value={user.password} onChange={handleChange} />
      </div>
      <div>
        <label>Projet :</label>
        <input type="text" name="projet" value={user.projet} onChange={handleChange} />
      </div>
      <div>
        <label>Photo :</label>
        <input type="file" name="photo" accept="image/*" onChange={handleChange} />
      </div>
      <button type="submit" className="button_submit">Enregistrer</button>
    </form>
  );
};

export default MonProfils;
