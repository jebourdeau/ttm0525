import React from 'react';


const API_URL="http://localhost:8080/api/users";
export const getAllUsers= async ()=> {
    try{
        const response = await fetch.get(API_URL);
        return response.data;
    }catch(error){
        console.error('Error Fetch', error);
        throw error;
    }
};

export const createUser = async (user)=>{
    try {
        const response = await fetch.post(API_URL, user);
        return response.data;
    } catch (error) {
        console.error("Error Create", error);
        throw error;
    }
}

const userService = () => {
    return (
        <div>
            
        </div>
    );
};

export default userService;