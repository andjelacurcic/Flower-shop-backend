import React from 'react';
import Axios from '../../apis/Axios';
import {Row, Col, Button, Table, Form} from 'react-bootstrap'
import './../index.css';
import {withParams, withNavigation} from '../../routeconf'


class Product extends React.Component{

    constructor(props) {
        super(props);

        const search = {
            name: "",
            minDuration: "",
            maxDuration: ""
        }
        this.state = { 
           products: [],
            search: search
        }
    }
    componentDidMount() {
        this.getProduct();
    }

    getProduct() {
        let config={
            params:{
                name: this.state.search.name,
                price: this.state.search.minDuration,
                available: this.state.search.maxDuration
            }
        }
        if(this.state.search.name != ""){
            config.params['name'] = this.state.search.name;
        }

        Axios.get('/product',config)
        .then(res => {
             // handle success
             console.log(res);
             this.setState({
                 products: res.data,
                });
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Error occured please try again!');
        });
    }

    deleteFromState(productId) {
        var products = this.state.products;
        products.forEach((element, index) => {
            if (element.id === productId) {
                products.splice(index, 1);
                this.setState({products: products});
            }
        });
    }
    getCategoryStringFromList(list) {
        return list.map(element => element.category).join(',');
    }

    delete(productId) {
        Axios.delete('/products/' + productId)
        .then(res => {
            // handle success
            console.log(res);
            alert('Product was deleted successfully!');
            this.deleteFromState(productId); // ili refresh page-a window.location.reload();
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Error occured please try again!');
         });
    }

    onInputChange(event){
        const name = event.target.name;
        const value = event.target.value

        let search=this.state.search;
        search[name] = value;

        this.setState({search})
    }

    renderProducts() {
        return this.state.products.map((product, index) => {
            return (
               <tr key={product.id}>
                  <td>{product.name}</td>
                  <td>{product.price}</td>
                  <td>{product.avlbl.toString()}</td>
                  {window.localStorage['role']=='ROLE_ADMIN'?
                  [<td><Button variant="warning" onClick={() => this.goToEdit(product.id)}>Edit</Button></td>,
                  <td><Button variant="danger" onClick={() => this.delete(product.id)}>Delete</Button></td>]
                  :null}
               </tr>
            )
         })
    }

    goToAdd() {
        this.props.navigate('/products/add');  
    }

    goToEdit(productId) {
        this.props.navigate('/products/edit/'+ productId); 
    }

    render() {
        return (
            <Col>
                <Row><h1>Product</h1></Row>

                <Row>
                <Form style={{width:"100%"}}>
                    <Row><Col>
                    <Form.Group>
                        <Form.Label>Name</Form.Label>
                        <Form.Control 
                            value={this.state.search.name}
                            name="name"
                            as="input"
                            type="text"
                            onChange={(e)=>this.onInputChange(e)}></Form.Control>
                    </Form.Group>
                    </Col></Row>

                   
                </Form>
                </Row>
                <Row>
                <Button onClick={()=>this.getProduct()}>Search</Button>
                </Row>
                <br/>

                {window.localStorage['role']=='ROLE_ADMIN'?
                <Row>
                    <Button onClick={() => this.goToAdd() }>Add</Button>
                    <br/><br/>
                </Row>:null}
                
                <Row>
                    <Table style={{marginTop:5}}>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Price </th>
                                <th>Available</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderProducts()}
                        </tbody>                  
                    </Table>
                </Row>
            </Col>
        );
    }

}

export default withNavigation(withParams(Product));