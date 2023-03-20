import React from "react";

const productTerm = (props) => {
    return(
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.price}</td>
            <td>{props.term.quantity}</td>
            <td>{props.term.category.name}</td>
            <td>{props.term.manufacturer.name}</td>
        </tr>
    );
}

export default productTerm;