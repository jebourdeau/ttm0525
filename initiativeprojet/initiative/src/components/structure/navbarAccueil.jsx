import { Link } from 'react-router-dom';
import "../../styles/navbarAccueil.css";
import { AuthContext } from '../../context/AuthContext';
import { useContext } from 'react';

export const NavbarAccueil = () => {
    const { auth } = useContext(AuthContext);
    const {user, porteur, admin, parrain}= auth;
    if (!auth) {
        return null;
    }
    if (auth && user) {
        return (
            <nav className="navbar">
            <div className="navbar-left">
            <Link to="/messagerie">Messagerie</Link>
            <Link to="/profils">Profils</Link>
            <Link to="/rendezvous">Rendez-vous</Link>
            <Link to="/apropos">A Propos</Link>
            </div>
            </nav>
        );
    }
    if (auth && porteur) {
        return (
            <nav className="navbar">
            <div className="navbar-left">
            <Link to="/messagerie">Messagerie</Link>
            <Link to="/rendezvous">Rendez-vous</Link>
            <Link to="/apropos">A Propos</Link>
            </div>
            </nav>
        );
    }
    if (auth && admin) {
        return (
            <nav className="navbar">
            <div className="navbar-left">
            <Link to="/profils">Profils</Link>
            <Link to="/rendezvous">Rendez-vous</Link>
            </div>
            </nav>
        );
    }
    if(auth && parrain){
        return (
            <nav className="navbar">
            <div className="navbar-left">
            <Link to="/profils">Profils</Link>
            <Link to="/rendezvous">Rendez-vous</Link>
            <Link to="/messagerie">Messagerie</Link>
            </div>
            </nav>
        );
    }
};
