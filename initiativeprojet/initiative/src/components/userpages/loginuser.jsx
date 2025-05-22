import { useCallback, useState } from "react";
import "../../styles/login.css";
import { useAuth } from "../../context/AuthContext";
import Loader from "../structure/Loader";

export const Loginuser = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [isLogin, setIsLogin] = useState(true);
    const [login, register] = useAuth();
    const [authLoading, setAuthLoading] = useState(false);
    
    const handleSubmit = useCallback(async (e)=>{
        e.preventDefault();
        setAuthLoading(true);
        setError('');
        
        const success = isLogin
        ? await login(username, password)
        : await register(username, password);
        if (!success) {
        setError(isLogin ? 'Loggin failed' : 'Registration failed');
        }
        setAuthLoading(false);
    }, [username, password, isLogin, login, register, setAuthLoading]);
    
    return(
    <>
        <div>
            <h2>{isLogin? "Login":"Register"}Connectez-vous</h2>
            {error && <div className="error">{error}</div>}
            {authLoading && <Loader/>}
            <form className="login-case" onSubmit={handleSubmit}>
                <label title="Identifiant">Identifiant</label>
                <input type='text' name='Identifiant' placeholder='Identifiant'/>
                <label title="mot_de_passe">Mot de Passse</label>
                <input type='text' name='Mot de passe' placeholder='Password'/>
                <input type='submit' className='button_submit'></input>
            </form>
            </div>
    </>
    );
};