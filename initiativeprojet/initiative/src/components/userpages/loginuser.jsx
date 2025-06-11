import { useCallback, useState } from "react";
import { useAuth } from "../../context/AuthContext";
import "../../styles/login.css";
import Loader from "../structure/Loader";

export const Loginuser = () => {
    const [error, setError] = useState('');
    const [isLogin, setIsLogin] = useState(true);
    const { login, register } = useAuth();
    const [authLoading, setAuthLoading] = useState(false);

    const handleSubmit = useCallback(async (e) => {
        e.preventDefault();
        setAuthLoading(true);
        setError('');
        const {username, password, role, age, email} = Object.fromEntries(new FormData(e.target));
        console.log(isLogin, username, password, role, age, email);
        const success = isLogin
        ? await login(username, password)
        : await register(username, password, email, role, age);

        if (!success) {
        setError(isLogin ? 'Échec de la connexion' : 'Échec de l\'inscription');
        }

        setAuthLoading(false);
    }, [isLogin, login, register]);

    return (
        <div className="login-container">
        <h2>{isLogin ? "Connexion" : "Inscription"}</h2>
        {error && <div className="error">{error}</div>}
        {authLoading && <Loader />}
        <form className="login-case" onSubmit={handleSubmit}>
            <label>Identifiant</label>
            <input
            type="text"
            name="username"
            placeholder="Identifiant"
            />
            <label>Mot de passe</label>
            <input
            type="password"
            name="password"
            placeholder="Mot de passe"
            />
            
            {!isLogin && (
            <>
                <label>Email</label>
                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                />
                <label>Âge</label>
                <input
                    type="number"
                    name="age"
                    placeholder="Âge"
                />
                <label>Rôle</label>
                <select name="role">
                <option value="porteur">Utilisateur</option>
                <option value="parrain">Parrain</option>
                <option value="admin">Admin</option>
                </select>
            </>
            )}
            <input
            type="submit"
            className="button_submit"
            value={isLogin ? "Se connecter" : "S'inscrire"}
            />
        </form>
        <div className="toggle-auth">
            {isLogin ? (
            <p>Pas encore de compte ? <button onClick={() => setIsLogin(false)}>Créer un compte</button></p>
            ) : (
            <p>Déjà inscrit ? <button onClick={() => setIsLogin(true)}>Se connecter</button></p>
            )}
        </div>
        </div>
    );
    };
