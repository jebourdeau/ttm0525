import React, { useState, useEffect } from 'react';
import '../../styles/cookieBanner.css';

const CookieBanner = () => {
    const [visible, setVisible] = useState(false);

    useEffect(() => {
        const consent = localStorage.getItem('cookieConsent');
        if (!consent) {
        setVisible(true);
        }
    }, []);

    const handleConsent = (value) => {
        localStorage.setItem('cookieConsent', value);
        setVisible(false);
    };

    if (!visible) return null;

    return (
        <div className="cookie-banner">
        <p>
            En acceptant les cookies, vous acceptez notre politique de cookies.
            en acceptant uniquement les cookies nécessaires, vos données ne seront utilisées que pour améliorer votre expérience utilisateur.
        </p>
        <div className="cookie-buttons">
            <button onClick={() => handleConsent('accepted')}>J'accepte </button>
            <button onClick={() => handleConsent('necessary')}>uniquement les nécessaires</button>
            <button onClick={() => handleConsent('refused')}>Refuser</button>
        </div>
        </div>
    );
    };

export default CookieBanner;
