import { useCallback, useState } from "react";
import "../../styles/login.css";
import { useAuth } from "../../context/AuthContext";
import Loader from "../structure/Loader";

export const Loginuser = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [isLogin, setIsLogin] = useState(true);
    const { login, register } = useAuth();
    const [authLoading, setAuthLoading] = useState(false);

    const handleSubmit = useCallback(async (e) => {
        e.preventDefault();
        setAuthLoading(true);
        setError('');

        const success = isLogin
        ? await login(username, password)
        : await register(username, password);

        if (!success) {
        setError(isLogin ? 'Échec de la connexion' : 'Échec de l\'inscription');
        }

        setAuthLoading(false);
    }, [username, password, isLogin, login, register]);

    return (
        <div className="login-container">
        <h2>{isLogin ? "Connexion" : "Inscription"}</h2>
        {error && <div className="error">{error}</div>}
        {authLoading && <Loader />}
        <form className="login-case" onSubmit={handleSubmit}>
            <label>Identifiant</label>
            <input
            type="text"
            name="Identifiant"
            placeholder="Identifiant"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            />
            <label>Mot de passe</label>
            <input
            type="password"
            name="Mot de passe"
            placeholder="Mot de passe"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            />
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
