import PropTypes from "prop-types";
import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

const MonPage = ({}) => {
    const [nb1Add, setNb1Add] = useState(0)
    const [nb2Add, setNb2Add] = useState(0)
    const [resultatAdd, setResultatAdd] = useState(0)
    const [nb1, setNb1] = useState(0)
    const [nb2, setNb2] = useState(0)
    const [resultatSoustrait, setResultatSoustrait] = useState(0)
    const onSubmitAdd = async (e) => {
        e.preventDefault()
        if (!nb1Add || !nb2Add) {
            alert('ajouter chaque champs')
            return
        }

        await fetch('http://localhost:8080/add',
            {
                method: 'PUT',
                headers: {
                    'Content-type': 'application/json',
                },
                body: JSON.stringify({
                    nombre1 : nb1Add,
                    nombre2 : nb2Add
                })
            }).then(
                async resutlAdd => {
                    const data = await resutlAdd.json()
                    setResultatAdd(data.resultat)
                }
        )
    }

    const onSubmitSoustrait = async (e) => {
        e.preventDefault()
        if (!nb1 || !nb2) {
            alert('ajouter chaque champs')
            return
        }

        await fetch('http://localhost:8080/soustrait',
            {
                method: 'PUT',
                headers: {
                    'Content-type': 'application/json',
                },
                body: JSON.stringify({
                    nombre1 : nb1,
                    nombre2 : nb2
                })
            }).then(
            async resutlSoustrait => {
                const data = await resutlSoustrait.json()
                setResultatSoustrait(data.resultat)
            }
        )

    }
    return (
        <div style={{textAlign: "center"}}>
            <div style={{backgroundColor:"black",color: "white", padding:5}}>
                <h1>Examen Intra</h1>
                <h3>Calculatrice web</h3>
            </div>
            <form style={{textAlign: "center"}} className='add-form' onSubmit={onSubmitAdd}>
                <div className='form-control'>
                    <label>One</label>
                    <input data-testid="addNb1" type='number' placeholder='One'
                           value={nb1Add}
                           onChange={(e) => setNb1Add(e.target.value)}/>
                </div>
                <div className='form-control'>
                    <label>Two</label>
                    <input  data-testid="addNb2" type='number' placeholder='Two'
                           value={nb2Add}
                           onChange={(e) => setNb2Add(e.target.value)}/>
                </div>
                <input type='submit' value='Additionne'/>
            </form>
            <h1 style={{textAlign: "center"}}>{resultatAdd}</h1>

            <form style={{textAlign: "center"}} className='add-form' onSubmit={onSubmitSoustrait}>
                <div className='form-control'>
                    <label>One</label>
                    <input data-testid="souNb1" type='number' placeholder='One'
                           value={nb1}
                           onChange={(e) => setNb1(e.target.value)}/>
                </div>
                <div className='form-control'>
                    <label>Two</label>
                    <input  data-testid="souNb2"  type='number' placeholder='Two'
                           value={nb2}
                           onChange={(e) => setNb2(e.target.value)}/>
                </div>
                <input type='submit' value='Soustrait'/>
            </form>
            <h1 style={{textAlign: "center"}}>{resultatSoustrait}</h1>
        </div>
    )
}

MonPage.propTypes = {
}
export default MonPage
