
import React, { useState, useEffect } from 'react';
import '../../../styles/profils.css';

const Profils = () => {
    const [profilsData, setProfilsData] = useState([]);
    const [currentIndex, setCurrentIndex] = useState(0);

    useEffect(() => {
        fetch('http://localhost:8080/users')
        .then((res) => res.json())
        .then((data) => setProfilsData(data))
        .catch((err) => console.error('Erreur de chargement des profils :', err));
    }, []);

    const handlePrev = () => {
        setCurrentIndex((prevIndex) => (prevIndex === 0 ? profilsData.length - 1 : prevIndex - 1));
    };

    const handleNext = () => {
        setCurrentIndex((prevIndex) => (prevIndex === profilsData.length - 1 ? 0 : prevIndex + 1));
    };

    if (profilsData.length === 0) return <p>Chargement des profils...</p>;

    const profil = profilsData[currentIndex];

return (
<div className="profils-carousel">
    <div className="carousel-container">
    <button className="carousel-button prev" onClick={handlePrev}>
        &#10094;
    </button>
    <div className="profil-card">
        <img src={profil.photo || 'default.jpg'} alt={profil.nom} className="profil-photo" />
        <h3>{profil.nom}</h3>
        <p>Âge: {profil.age}</p>
        <p>{profil.role}</p>
        <p>{profil.projet}</p>
    </div>
    <button className="carousel-button next" onClick={handleNext}>
        &#10095;
    </button>
    </div>
</div>
);
};

export default Profils;
