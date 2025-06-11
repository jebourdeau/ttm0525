import { Link, useNavigate } from 'react-router-dom';
import "../../styles/navbarAccueil.css";
import { AuthContext } from '../../context/AuthContext';
import { useContext } from 'react';

export const NavbarAccueil = () => {
    const { auth, logout } = useContext(AuthContext);
    const navigate = useNavigate();

    if (!auth) {
        return (
        <nav className="navbar">
            <div className="navbar-left">
            <Link to="/">Accueil</Link>
            </div>
        </nav>
        );
    }

    const handleLogout = () => {
        logout();
        navigate('/');
    };
    const { username, role } = auth;
    console.log(username, role);
    const commonLinks = (
        <>
            <Link to="/messagerie">Messagerie</Link>
            <Link to="/rendezvous">Rendez-vous</Link>
            <button onClick={handleLogout} className="logout-button">Déconnexion</button>
        </>
    );

    return (
        <nav className="navbar">
            <div className="navbar-left">
                {username && (
                    <>
                        {commonLinks}
                        <Link to="/profils">Profils</Link>
                        <Link to="/apropos">A Propos</Link>
                    </>
                )}
                {role == "porteur" && (
                    <>
                        {commonLinks}
                        <Link to="/apropos">A Propos</Link>
                    </>
                )}
                {role == "admin" && (
                    <>
                        <Link to="/profils">Profils</Link>
                        {commonLinks}
                    </>
                )}
                {role == "parrain" && (
                    <>
                        <Link to="/profils">Profils</Link>
                        {commonLinks}
                    </>
                )}
            </div>
        </nav>
    );
};
