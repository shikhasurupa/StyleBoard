import React from 'react'
import Header from '../../components/header/Header'

const Home = () => {
  return (
    <>
    <Header />


    <div style={{
      display: 'flex',
      justifyContent:'center',
      alignItems:'center' ,
      fontWeight:'bold', 
      marginTop: '8rem'
    }}>Home Page</div>

    </>
  )
}

export default Home