import React from "react";
import ProductTerm from "../ProductTerm/productTerm";
import {Link} from "react-router-dom";
import ReactPaginate from "react-paginate";

class Products extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 2
        }
    }

    render() {

        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.products.length / this.state.size);
        const products = this.getProductsPage(offset, nextPageOffset);

        return (
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"row"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Price</th>
                                <th scope={"col"}>Quantity</th>
                                <th scope={"col"}>Category</th>
                                <th scope={"col"}>Manufacturer</th>
                            </tr>
                            </thead>
                            <tbody>
                            {products}
                            </tbody>
                        </table>
                    </div>
                    <div className={"col mb-3"}>
                        <div className={"row"}>
                            <div className={"col-sm-12 col-md-12"}>
                                <Link className={"btn btn-block btn-dark"} to={"/products/add"}>
                                    Add new product
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
                <ReactPaginate previousLabel={"back"}
                               nextLabel={"next"}
                               breakLabel={<a href="/#">...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}/>
            </div>
        );
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
           page: selected
        });
    }

    getProductsPage = (offset, nextPageOffset) => {
        return this.props.products.map((term) => {
            return (
                <ProductTerm term={term}
                             onDelete={this.props.onDelete}
                             onEdit={this.props.onEdit}/>
            );
        }).filter((product, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }
}

export default Products;