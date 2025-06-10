import { Link, useNavigate } from 'react-router-dom';
import "../../styles/navbarAccueil.css";
import { AuthContext } from '../../context/AuthContext';
import { useContext } from 'react';

export const NavbarAccueil = () => {
    const { auth, logout } = useContext(AuthContext);
    const navigate = useNavigate();

    if (!auth) return null;

    const handleLogout = () => {
        logout();
        navigate('/');
    };

    const { user, porteur, admin, parrain } = auth;

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
                {user && (
                    <>
                        {commonLinks}
                        <Link to="/profils">Profils</Link>
                        <Link to="/apropos">A Propos</Link>
                    </>
                )}
                {porteur && (
                    <>
                        {commonLinks}
                        <Link to="/apropos">A Propos</Link>
                    </>
                )}
                {admin && (
                    <>
                        <Link to="/profils">Profils</Link>
                        {commonLinks}
                    </>
                )}
                {parrain && (
                    <>
                        <Link to="/profils">Profils</Link>
                        {commonLinks}
                    </>
                )}
            </div>
        </nav>
    );
};
