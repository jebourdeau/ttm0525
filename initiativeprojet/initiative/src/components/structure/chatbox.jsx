import React, { useState } from 'react';
import '../../styles/chatbox.css';

const Chatbox = () => {
    const [messages, setMessages] = useState([]);
    const [input, setInput] = useState('');
    const [isOpen, setIsOpen] = useState(false);

    const handleSend = () => {
        if (input.trim()) {
        setMessages([...messages, { text: input, sender: 'user' }]);
        setInput('');
        // Simuler une réponse du bot
        setTimeout(() => {
            setMessages((prevMessages) => [
            ...prevMessages,
            { text: 'Réponse du bot', sender: 'bot' }
            ]);
        }, 1000);
        }
    };

    return (
        <div className={`chatbox-container ${isOpen ? 'open' : ''}`}>
        <div className="chatbox-header" onClick={() => setIsOpen(!isOpen)}>
            <span>Chat</span>
        </div>
        {isOpen && (
            <div className="chatbox">
            <div className="chatbox-body">
                {messages.map((msg, index) => (
                <div key={index} className={`chatbox-message ${msg.sender}`}>
                    {msg.text}
                </div>
                ))}
            </div>
            <div className="chatbox-footer">
                <input
                type="text"
                value={input}
                onChange={(e) => setInput(e.target.value)}
                placeholder="Comment puis-je vous aider"
                />
                <button onClick={handleSend}>Send</button>
            </div>
            </div>
        )}
        </div>
    );
};

export default Chatbox;