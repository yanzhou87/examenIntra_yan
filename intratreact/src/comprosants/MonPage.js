import PropTypes from "prop-types";
import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

const MonPage = ({}) => {

    return (
        <div className="pageCenter">
            <table>
                <thead>
                <tr>
                    <th>yan</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>

                </thead>
            </table>
            <Link to="/"><button>Create</button></Link>
        </div>
    )
}

MonPage.propTypes = {
}
export default MonPage
