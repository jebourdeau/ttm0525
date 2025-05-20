
import './App.css';
import Header from './components/structure/header';
import Footer from './components/structure/footer';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Apropos } from './components/pages/apropos';
import Rendezvous from './components/pages/boitesOutils/rendezvous';
import NotFound from './components/pages/notFound';
import { Registeruser } from './components/userpages/registeruser';
import { Loginuser } from './components/userpages/loginuser';
import { Body } from './components/structure/body';
import { Messagerie } from './components/pages/boitesOutils/messagerie';
import Profils  from './components/pages/boitesOutils/profils';
import { UserList } from './components/userpages/userList';

function App() {
  return (
    <BrowserRouter>
    <Header/>
    <Body/>
    <Routes>
        <Route path="/" element={<Loginuser/>} />
        <Route path="/notfound" element={<NotFound/>} />
        <Route path="/users" element={<UserList/>} />
        <Route path="/apropos" element={<Apropos/>} />
        <Route path="/register" element={<Registeruser/>} />
        <Route path="/messagerie" element={<Messagerie/>} />
        <Route path="/profils" element={<Profils/>} />
        <Route path="/rendezvous" element={<Rendezvous/>} />
    </Routes>
    <Footer/>
  </BrowserRouter>
  );
}

export default App;
