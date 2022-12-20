import React from "react";

import '../Styles/NavBar.css'
import {ReactComponent as Logo} from '../logo.svg'
import { Link } from "react-router-dom";

const NavBar = () =>{
    return(
        <>
            <nav className="navbar">
                <div className="logo-box">
                    <Logo/>
                </div>

                <ul className="navbar-menu">
                    <li><Link to="/">Who We Are</Link></li>
                    <li>What We Do</li>
                    <li>Why Us</li>
                    <li>Our Impact</li>
                    <li>News</li>
                    <li> <Link to="/search">Career</Link></li>
                    <li> <Link to="/post">Job Posts</Link></li>
                    <li>Contact</li>
                </ul>
            </nav>
        </>
    )
}
export default NavBar;