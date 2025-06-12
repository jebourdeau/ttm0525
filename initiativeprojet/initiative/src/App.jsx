
import './App.css';
import Header from './components/structure/header';
import Footer from './components/structure/footer';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Apropos } from './components/pages/apropos';
import Rendezvous from './components/pages/boitesOutils/rendezvous';
import NotFound from './components/pages/notFound';
import { Loginuser } from './components/userpages/loginuser';
import { Body } from './components/structure/body';
import { Messagerie } from './components/pages/boitesOutils/messagerie';
import Profils  from './components/pages/boitesOutils/profils';
import { AuthProvider, useAuth } from './context/AuthContext';
import { Accueil } from './components/pages/accueil';
import {Documents} from './components/pages/boitesOutils/documents';
import MonProfils from './components/pages/boitesOutils/monProfils';


function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <MainApp />
      </BrowserRouter>
    </AuthProvider>
  );
}

function MainApp() {
  const { auth } = useAuth();

  // if (!auth) {
  //   return <Loginuser />;
  // }

  return (
    <>
      <Header />
      <Body />
      <Routes>
        {!auth ? (<Route path="*" element={<Loginuser />} />
        ) : (<>
        
        <Route path="/" element={<Accueil />} />
        <Route path="/notfound" element={<NotFound />} />
        <Route path="/apropos" element={<Apropos />} />
        <Route path="/documents" element={<Documents />} />
        <Route path="/messagerie" element={<Messagerie />} />
        <Route path="/profils" element={<Profils />} />
        <Route path="/rendezvous" element={<Rendezvous />} />
        <Route path="*" element={<NotFound />} />
        <Route path= "/monprofils" element={<MonProfils/>} />
        </>)}
      </Routes>
      <Footer />
    </>
  );
}
export default App;
