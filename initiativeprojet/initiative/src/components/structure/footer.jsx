import logo from "../../assets/img/Nouvelle_Aquitaine-Logo-Reseau_Initiative-RVB_1.webp";
import "../../styles/footer.css";
import Chatbox from "./chatbox";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebook, faInstagram, faLinkedin } from '@fortawesome/free-brands-svg-icons';

const Footer = () => {
    return (
        <footer className="footer-content">
        <div>
            <p>Suivez-nous sur les réseaux sociaux</p>
            <a href="https://www.facebook.com/people/Initiative-Nouvelle-Aquitaine/61556254867502/" target="_blank" rel="noopener noreferrer" title="Facebook">
            <FontAwesomeIcon className="favicon" icon={faFacebook} />
            <span className="réseau">Facebook</span>
            </a>
            <a href="https://www.instagram.com/initiativefrance/?igshid=YmMyMTA2M2Y%3D" target="_blank" rel="noopener noreferrer" title="Instagram">
            <FontAwesomeIcon className="favicon" icon={faInstagram} />
            <span className="réseau">Instagram</span>
            </a>
            <a href="https://www.linkedin.com/company/initiative-nouvelle-aquitaine/?viewAsMember=true" target="_blank" rel="noopener noreferrer" title="Linkedin">
            <FontAwesomeIcon className="favicon" icon={faLinkedin} />
            <span className="réseau">Linkedin</span>
            </a>
        </div>
        <a href="https://www.initiative-nouvelleaquitaine.fr/"><img src={logo} alt="initiative" className="logo" /></a>
        <p>© 2024 Initiative Deux Sèvres, Simplon &hearts; </p>
        <Chatbox />
        </footer>
    );
};

export default Footer;