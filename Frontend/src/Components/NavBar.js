import React from "react";
import '../Styles/NavBar.css'
import {ReactComponent as Logo} from '../logo.svg'

const NavBar = () =>{
    return(
        <>
            <nav className="navbar">
                <div className="logo-box">
                    <Logo/>
                </div>

                <ul className="navbar-menu">
                    <li>Who We Are</li>
                    <li>What We Do</li>
                    <li>Why Us</li>
                    <li>Our Impact</li>
                    <li>News</li>
                    <li>Careers</li>
                    <li>Contact</li>
                </ul>
            </nav>
        </>
    )
}
export default NavBar;