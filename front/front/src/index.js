import React from 'react';
import ReactDOM  from 'react-dom';
import { Route, Link, HashRouter as Router, Routes } from 'react-router-dom';
import { logout } from './services/auth';
import Home from './components/Home';
import Login from './components/authorization/Login';
import { Button, Container, Nav, Navbar } from 'react-bootstrap';
import Product from './components/products/Product';
import AddProduct from './components/products/AddProduct';
//import EditProduct from './components/products/EditProduct';

class App extends React.Component {

    //cd \......
    //npm install
    //npm install react-router-dom
    //npm install axios
    //npm install react-bootstrap
    // npm install jwt-decode
    //npm start

    render(){
        
        const jwt = window.localStorage['jwt'];

        if(jwt){
            return(
                
                <>
                <Router>
                    <Navbar expand bg="dark" variant="dark">
                        <Navbar.Brand as={Link} to="/">
                            JWD
                        </Navbar.Brand>
                        <Nav>
                            <Nav.Link as={Link} to="/products">
                                Products
                            </Nav.Link>
                           

                            <Button onClick={()=>logout()}>logout</Button>
                        </Nav>
                    </Navbar>
                    <Container style={{paddingTop:"10px"}}>
                        <Routes>
                            <Route path="/" element={<Home/>}/>
                            <Route path="/products" element={<Product/>}/> 
                            <Route path="/products/add" element={<AddProduct/>}/> 
                            <Route path="/products/edit/:id" element={<Product/>}/> 
                            {/* {<PutanjaNeka/>} se menja, izbacice gresku ako se ovako pokrene 
                            cd \......
                            npm install
                            npm install react-router-dom
                            npm install axios
                            npm install react-bootstrap
                            npm install jwt-decode
                            npm start
                            */}
                            <Route path="/login" element={<Login/>}/>
                        </Routes>
                    </Container>
                </Router>

                </>
        );  
        }else{
            return(
                <>
                <Router>
                    <Navbar expand bg="dark" variant="dark">
                        <Navbar.Brand as={Link} to="/">
                            JWD
                        </Navbar.Brand>
                        <Nav>
                            <Nav.Link as={Link} to="/putanja_neka">
                                Putanja Neka
                            </Nav.Link>
                            <Nav.Link as={Link} to="/login">
                            Login
                            </Nav.Link>
                        </Nav>
                    </Navbar>
                    <Container style={{paddingTop:"10px"}}>
                        <Routes>
                            <Route path='/' element={<Home/>}/>
                            {/* <Route path="/putanja_neka" element={<PutanjaNeka/>}/> */}
                            {/* {<PutanjaNeka/>} se menja, izbacice gresku ako se ovako pokrene 
                            cd \......
                            npm install
                            npm install react-router-dom
                            npm install axios
                            npm install react-bootstrap
                            npm install jwt-decode
                            npm start
                            */}
                            <Route path="/login" element={<Login/>}/>
                        </Routes>
                    </Container>
                </Router>

                </>
            );
        }
        
    }
}

ReactDOM.render(
    <App/>,
    document.querySelector('#root')
);