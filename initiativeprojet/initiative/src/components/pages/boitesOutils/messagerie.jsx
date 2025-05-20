import React, { useState } from 'react';
import emailjs from 'emailjs-com';
import "../../../styles/login.css";

export const Messagerie = () => {
    const [email, setEmail] = useState('');
    const [message, setMessage] = useState('');

    const sendEmail = (e) => {
        e.preventDefault();

        const templateParams = {
        email,
        message,
        };

        emailjs.send('YOUR_SERVICE_ID', 'YOUR_TEMPLATE_ID', templateParams, 'YOUR_USER_ID')
        .then((response) => {
            console.log('Email sent successfully!', response.status, response.text);
        }, (error) => {
            console.error('Failed to send email.', error);
        });
    };

    return (
        <div>
        <form onSubmit={sendEmail}>
            <label htmlFor="email">Email</label>
            <input
            type="email"
            id="email"
            name="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            />
            <label htmlFor="message">Message</label>
            <textarea
            id="message"
            name="message"
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            required
            />
            <button className='button_submit' type="submit">Envoyer</button>
        </form>
        </div>
    );
};