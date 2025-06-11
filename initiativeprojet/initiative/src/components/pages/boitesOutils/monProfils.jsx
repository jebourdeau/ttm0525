import React, { useState, useEffect } from 'react';



const MonProfil = ({ userId }) => {
  const [profil, setProfil] = useState(null);

  useEffect(() => {
    fetch(`http://localhost:8080/users/${userId}`)
      .then((res) => res.json())
      .then((data) => setProfil(data))
      .catch((err) => console.error('Erreur de chargement du profil :', err));
  }, [userId]);

  if (!profil) return <p>Chargement du profil...</p>;

  return (
    <div className="profil-card">
      <img
        src={profil.photo || profil-Homme.jpg}
        alt={profil.nom}
        className="profil-photo"
      />
      <h3>{profil.nom}</h3>
      <p>Âge: {profil.age}</p>
      <p>{profil.role}</p>
      <p>{profil.projet}</p>
    </div>
  );
};

export default MonProfil;
