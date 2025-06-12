import React, { useState } from 'react';
import '../../../styles/profils.css';

function MonProfils() {
  const [formData, setFormData] = useState({
    nom: '',
    prenom: '',
    adresse: '',
    telephone: '',
    photo: null,
  });

  const handleChange = (e) => {
    const { name, value, files } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: files ? files[0] : value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Formulaire soumis :', formData);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Nom :</label>
        <input type="text" name="nom" value={formData.nom} onChange={handleChange} required />
      </div>
      <div>
        <label>Prénom :</label>
        <input type="text" name="prenom" value={formData.prenom} onChange={handleChange} required />
      </div>
      <div>
        <label>Adresse :</label>
        <input type="text" name="adresse" value={formData.adresse} onChange={handleChange} required />
      </div>
      <div>
        <label>Téléphone :</label>
        <input type="tel" name="telephone" value={formData.telephone} onChange={handleChange} required />
      </div>
      <div>
        <label>Photo :</label>
        <input type="file" name="photo" accept="image/*" onChange={handleChange} />
      </div>
      <button type="submit" className='button_submit'>Enregistrer</button>
    </form>
  );
}

export default MonProfils;
