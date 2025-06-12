import React, { useState, useEffect } from 'react';

export const Documents = () => {
  const [file, setFile] = useState(null);
  const [description, setDescription] = useState('');
  const [preview, setPreview] = useState(null);
  const [status, setStatus] = useState('');
  const [documents, setDocuments] = useState([]);

  useEffect(() => {
    fetchDocuments();
  }, []);
  useEffect(() => {
    // Simulation de documents en dur
    const fakeDocuments = [
      {
        id: '1',
        filename: 'cv_julie_durand.pdf',
        description: 'CV de Julie Durand',
      },
      {
        id: '2',
        filename: 'facture_mars_2025.pdf',
        description: 'Facture EDF - Mars 2025',
      },
      {
        id: '3',
        filename: 'photo_identite.png',
        description: 'Photo d’identité pour dossier',
      },
    ];
    setDocuments(fakeDocuments);
  }, []);
  

  const fetchDocuments = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/documents/api/list', {
        credentials: 'include',
      });
      const data = await response.json();
      setDocuments(data);
    } catch (error) {
      console.error('Erreur lors du chargement des documents :', error);
    }
  };

  const handleFileChange = (e) => {
    const selectedFile = e.target.files[0];
    setFile(selectedFile);

    if (selectedFile && selectedFile.type.startsWith('image/')) {
      const reader = new FileReader();
      reader.onloadend = () => setPreview(reader.result);
      reader.readAsDataURL(selectedFile);
    } else {
      setPreview(null);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!file || !description) {
      setStatus('❗ Veuillez remplir tous les champs.');
      return;
    }

    const formData = new FormData();
    formData.append('file', file);
    formData.append('description', description);

    try {
      const response = await fetch('http://localhost:8080/api/documents/upload', {
        method: 'POST',
        body: formData,
        credentials: 'include',
      });

      if (response.ok) {
        setStatus('✅ Document téléchargé avec succès.');
        setFile(null);
        setDescription('');
        setPreview(null);
        fetchDocuments();
      } else {
        setStatus('❌ Erreur lors du téléchargement du document.');
      }
    } catch (error) {
      console.error('Erreur lors de la requête:', error);
      setStatus('❌ Une erreur est survenue.');
    }
  };

  return (
    <div >
      <h2>📄 Téléverser un document</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <input type="file" onChange={handleFileChange} />
        </div>
        {preview && <img src={preview} alt="Aperçu" s />}
        <div>
          <input
            type="text"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            placeholder="Description"
          />
        </div>
        <button type="submit" className='button_submit' >📤 Envoyer</button>
      </form>
      {status && <p>{status}</p>}
      <h3>📚 Documents enregistrés</h3>
      <ul>
        {documents.map((doc) => (
          <li key={doc.id} >
            <strong>{doc.filename}</strong><br />
            <em>{doc.description}</em><br />
            <a href={`http://localhost:8080/api/documents/download/${doc.id}`} target="_blank" rel="noopener noreferrer">
              📥 Télécharger
            </a>
          </li>
        ))}
      </ul>
    </div>
  );
};
