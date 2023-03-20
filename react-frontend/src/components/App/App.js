import './App.css';
import {Component} from "react";
import {BrowserRouter as Router, Navigate, Route, Routes} from 'react-router-dom'
import Manufacturers from "../Manufacturers/manufacturers";
import Categories from "../Categories/categories";
import Products from "../Products/ProductList/products";
import Header from "../Header/header";
import EShopService from "../../repository/eshopRepository";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            manufacturers: [],
            products: [],
            categories: []
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className={"container"}>
                        <Routes>
                            <Route path={"/manufacturers"} exact element={ <Manufacturers manufacturers={this.state.manufacturers}/>}/>
                            <Route path={"/categories"} exact element={ <Categories categories={this.state.categories}/>}/>
                            <Route path={"/products"} exact element={ <Products products={this.state.products}/>}/>
                            <Route path="/" element={<Navigate replace to="/products" />} />
                        </Routes>

                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadManufacturers();
        this.loadCategories();
        this.loadProducts();

    }

    loadManufacturers = () => {
        EShopService.fetchManufacturers()
            .then((data) => {
                this.setState({
                    manufacturers: data.data
                })
            });
    }

    loadCategories = () => {
        EShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadProducts = () => {
        EShopService.fetchProducts()
            .then((data) => {
                this.setState({
                    products: data.data
                })
            });
    }
}

export default App;
