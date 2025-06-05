import React, { useState } from 'react';

export const Documents = () => {
const  [file, setFile]= useState(null);
    const [description, setDescription]= useState('');
    const handleFileChange = (e) => {
        setFile(e.target.files[0]);
    };
    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!file|| !description) {
            alert('Veuillez remplir tous les champs');
            return;}
        const formData = new FormData();
        formData.append('file', file);
        formData.append('description', description);
    
        try {
            const response = await fetch('http://localhost:8080/api/documents/upload', {
                method: 'POST',
                body: formData,
                credentials: 'include',
            });
            if(response.redirected) {
                window.location.href = response.url;
            } else if(response.ok){
                alert('Document téléchargé avec succès');
            } else {
                alert('Erreur lors du téléchargement du document');
            }}catch (error) {
            console.error('Erreur lors de la requête:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit} >
            <label >
                <input
                    type="file"
                    onChange={handleFileChange}
                />
            </label>
            <label>
                <input
                type="text"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                placeholder="Description"
                />
            </label>
        </form>
        
    );
};
