import React, { useState } from 'react';
import '../../../styles/profils.css';


// Importez vos images locales
import photo1 from '../../../assets/image/profil-Homme.jpg';
import photo2 from '../../../assets/image/profil-femme-bleu.jpg';
import photo3 from '../../../assets/image/profil-femme-bleu.jpg';

const profilsData = [
    {
        id: 1,
        photo: photo1,
        nom: 'Xavier Dupont',
        age: 53,
        role: 'Entrepreneur',
        projet: 'Maçonnerie générale, spécialisé dans les terrasses'
    },
    {
        id: 2,
        photo: photo2,
        nom: 'Greta Thunberg',
        age: 23,
        role: 'Investisseuse',
        projet: 'Investissement dans les technologies vertes'
    },
    {
        id: 3,
        photo: photo3,
        nom: 'Alice Martin',
        age: 28,
        role: 'Entrepreneuse',
        projet: 'Plateforme de e-commerce, spécialisé dans les objets insolites'
    },
];


const Profils = () => {
    const [currentIndex, setCurrentIndex] = useState(0);
    const handlePrev = () => {
        setCurrentIndex((prevIndex) => (prevIndex === 0 ? profilsData.length - 1 : prevIndex - 1));
    };

    const handleNext = () => {
        setCurrentIndex((prevIndex) => (prevIndex === profilsData.length - 1 ? 0 : prevIndex + 1));
    };
    return (
        <div className="profils-carousel">
        <div className="carousel-container">
            <button className="carousel-button prev" onClick={handlePrev}>
            &#10094;
            </button>
            <div className="profil-card">
            <img src={profilsData[currentIndex].photo} alt={`${profilsData[currentIndex].nom}`} className="profil-photo" />
            <h3>{profilsData[currentIndex].nom}</h3>
            <p>Âge: {profilsData[currentIndex].age}</p>
            <p>{profilsData[currentIndex].role}</p>
            <p>{profilsData[currentIndex].projet}</p>
            </div>
            <button className="carousel-button next" onClick={handleNext}>
            &#10095;
            </button>
        </div>
        </div>
    );
};
export default Profils;