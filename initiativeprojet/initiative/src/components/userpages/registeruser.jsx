import "../../styles/login.css";
import { createUser } from "../../services/userService";
import { useState } from "react";

export const Registeruser = () => {
    const [user, setUser]=useState({
        username:'',
        age:"",
        role: "",
        projet:"",
        email:"",
        password:""
    });
    const handleChange = (e) =>{
        const{name, value} = e.target;
        setUser({
            ...user,
            [name]:value
        })
    }
    const handleSubmit = async (e)=>{
        e.preventDefault();
        try {
            const newUser = await createUser(user);
            console.log("User Created:", newUser);
        } catch (error) {
            console.error("Error Createing user", error);
        }
    }

    return (
        <div>
            <h3>Vous n'avez pas de compte, créez-le maintenant</h3>
            <form onSubmit={handleSubmit} className="login-case">
                <label htmlFor="">
                    Nom:
                    <input type="text" name="username" value={user.username} onChange={handleChange} required/>
                </label>
                <label>
                    Âge:
                    <input type="number" name="age" value={user.age} onChange={handleChange} required/>
                </label>
                <label>
                    Email:
                    <input type="email" name="email" value={user.email} onChange={handleChange} required/>
                </label>
                <label>
                    Projet:
                    <input type="text" name="projet" value={user.projet} onChange={handleChange} required/>
                </label>
                <label>
                    Password:
                    <input type="password" name="password" value={user.password} onChange={handleChange} required/>
                </label>
                <div className="role-selection">
                    <label>
                        <input type="radio" name="role" value="porteur de projet" />
                        Porteur de projet
                    </label>
                    <label>
                        <input type="radio" name="role" value="parrain" />
                        Parrain
                    </label>
                </div>
                <button className="button_submit" type="submit">S'inscrire</button>
            </form>
            {/* <form className="login-case">
                <label title="Nom">Nom</label>
                <input type='text' name='Nom' placeholder='Nom' />
                <label title="Prenom">Prénom</label>
                <input type='text' name='prénom' placeholder='Prénom' />
                <label title="Identifiant">Identifiant</label>
                <input type='text' name='Identifiant' placeholder='Identifiant' />
                <label title="Email">Email</label>
                <input type='text' name='Email' placeholder='Email' />
                <label title="mot_de_passe">Mot de Passe</label>
                <input type='password' name='Mot de passe' placeholder='Password' />
                <br />
                <label title="Confirme_mot_de_passe">Confirme mot de passe</label>
                <input type='password' name='confirme password' placeholder='Confirmation' />
                <div className="role-selection">
                    <label>
                        <input type="radio" name="role" value="porteur de projet" />
                        Porteur de projet
                    </label>
                    <label>
                        <input type="radio" name="role" value="parrain" />
                        Parrain
                    </label>
                </div>
                <input type='submit' className='button_submit' />
            </form> */}
        </div>
    );
};