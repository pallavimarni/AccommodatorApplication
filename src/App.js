import React from 'react'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './App.css'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import Login from './Components/Registration'
import SignUp from './Components/Login'
import HomePage from './Components/HomePage'
import Preferences from "./Components/Preferences";
import Features from "./Components/Features";

//import Home from './Components/Posting'

function App() {
    return (
        <Router>
            <div className="App">
                <nav className="navbar navbar-expand-lg navbar-light fixed-top">
                    <div className="container">
                        <Link className="navbar-brand" to={'/'}>
                            ACCOMMODATOR
                        </Link>
                        <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                            <ul className="navbar-nav ml-auto">
                                <li className="nav-item">
                                    <Link className="nav-link" to={'/sign-up'}>
                                        Login
                                    </Link>
                                </li>
                                <li className="nav-item">
                                    <Link className="nav-link" to={'/sign-in'}>
                                        Sign up
                                    </Link>
                                </li>
                                <li className="nav-item">
                                    <Link className="nav-link" to={'/preferences'}>
                                        Preferences
                                    </Link>
                                </li>
                                <li className="nav-item">
                                    <Link className="nav-link" to={'/Features'}>
                                        Features
                                    </Link>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                            <Routes>
                                <Route exact path="/" element={<HomePage />} />
                                <Route path="/sign-in" element={<Login />} />
                                <Route path="/sign-up" element={<SignUp />} />
                                <Route path="/Preferences" element={<Preferences />} />
                                <Route path="/Features" element={<Features />} />
                            </Routes>

                <footer className="bg-light py-4">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-6">
                                <p>&copy; 2023 Your Company Name. All rights reserved.</p>
                            </div>
                            <div className="col-md-6">
                                <ul className="list-inline text-md-right">
                                    <li className="list-inline-item"><a href="#">Home</a></li>
                                    <li className="list-inline-item"><a href="#">About</a></li>
                                    <li className="list-inline-item"><a href="#">Contact</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>

        </Router>
    )
}
export default App