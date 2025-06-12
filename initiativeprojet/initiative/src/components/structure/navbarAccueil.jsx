import { useContext } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { AuthContext } from '../../context/AuthContext';
import "../../styles/navbarAccueil.css";

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
    const { username, role } = auth.payload;
    console.log('User infos', username, role, auth);
    // const commonLinks = (
    //     <>
    //         <Link to="/messagerie">Messagerie</Link>
    //         <Link to="/rendezvous">Rendez-vous</Link>
    //         <Link to="/documents">Documents</Link>
            
    //     </>
    // );

    return (
        <nav className="navbar">
            <div className="navbar-left">
                {username && (
                    <>
                        {/* {commonLinks} */}
                    </>
                )}
                {role === "porteur" && (
                    <>
                        {/* {commonLinks} */}
                        <Link to="/apropos">A Propos</Link>
                        <Link to="/rendezvous">Rendez-vous</Link>
                        <Link to="/monprofils">Mon Profils</Link>
                        <Link to="/messagerie">Messagerie</Link>
                        <Link to="/documents">Documents</Link>
                    </>
                )}
                {role === "admin" && (
                    <>
                        <Link to="/profils">Profils</Link>
                        <Link to="/monprofils"> Mon Profils</Link>
                        <Link to="/documents">Documents</Link>
                        {/* {commonLinks} */}
                    </>
                )}
                {role === "parrain" && (
                    <>
                        <Link to="/profils">Profils</Link>
                        <Link to="/rendezvous">Rendez-vous</Link>
                        <Link to="/messagerie">Messagerie</Link>
                        <Link to="/monprofils">Mon Profils</Link>
                        <Link to="/documents">Documents</Link>
                        {/* {commonLinks} */}
                    </>
                )}
            </div>
            <button onClick={handleLogout} className="logout-button">Déconnexion</button>
        </nav>
    );
};
