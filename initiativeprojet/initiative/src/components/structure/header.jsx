import "../../styles/header.css";
import logo2 from "../../assets/img/ttm_noir.webp";
import { NavbarAccueil } from "./navbarAccueil";
import { useNavigate } from "react-router-dom";


const Header = () => {
    const navigate = useNavigate();
    return (
    <header className="App-header">
        <img src={logo2} className="match" alt="TTM" title="Trouve Ton Match"/>
        <NavbarAccueil/>
    </header>
    );
};

export default Header;