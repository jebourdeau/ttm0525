
import React, { useState, useEffect } from 'react';
import '../../../styles/profils.css';
import imgF from '../../../assets/image/profil-femme-bleu.jpg';
import imgH from '../../../assets/image/profil-Homme.jpg';

const Profils = () => {
    const [profilsData, setProfilsData] = useState([]);
    const [currentIndex, setCurrentIndex] = useState(0);

    useEffect(() => {
        fetch('http://localhost:8080/users')
        .then((res) => res.json())
        .then((data) => setProfilsData(data))
        .catch((err) => console.error('Erreur de chargement des profils :', err));
    }, []);
    useEffect(() => {
        const fakeProfils = [
            {
                id: 1,
                username: 'Julie Durand',
                age: 28,
                role: 'Porteur de projet',
                projet: 'Création d’une application mobile',
                photo: imgF,
            },
            {
                id: 2,
                username: 'Marc Lefèvre',
                age: 35,
                role: 'Parrain',
                projet: 'Accompagnement de startups',
                photo: imgH,
            },
            {
                id: 3,
                username: 'Sophie Martin',
                age: 42,
                role: 'Admin',
                projet: 'Gestion de la plateforme',
                photo: imgF,
            },
            ];
            setProfilsData(fakeProfils);
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
        <img src={profil.photo || 'default.jpg'} alt={profil.photo} className="profil-photo" />
        <h3>{profil.username}</h3>
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
