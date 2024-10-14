// Function to fetch clothing items from the API
async function fetchClothingItems() {
    try {
        const response = await fetch('http://localhost:8080/clothing');
        if (!response.ok) throw new Error('Network response was not ok'); // Error handling for network issues
       
        const clothingItems = await response.json(); // Parsing JSON response
        displayItems(clothingItems, 'clothing'); // Calling function to display clothing items
    } catch (error) {
        console.error('Error fetching clothing items:', error); // Logging errors to console
        document.getElementById('items').innerHTML = '<p>Error fetching clothing items. Please try again later.</p>'; // Display error message
    }
}


// Function to fetch shoe items from the API
async function fetchShoeItems() {
    try {
        const response = await fetch('http://localhost:8080/shoes'); // Corrected URL to include '/api/'
        if (!response.ok) throw new Error('Network response was not ok'); // Error handling for network issues
       
        const shoeItems = await response.json(); // Parsing JSON response
        displayItems(shoeItems, 'shoes'); // Calling function to display shoe items
    } catch (error) {
        console.error('Error fetching shoe items:', error); // Logging errors to console
        document.getElementById('items').innerHTML = '<p>Error fetching shoe items. Please try again later.</p>'; // Display error message
    }
}


// Function to fetch hygiene items from the API
async function fetchHygieneItems() {
    try {
        const response = await fetch('http://localhost:8080/hygiene');
        if (!response.ok) throw new Error('Network response was not ok'); // Error handling for network issues
       
        const hygieneItems = await response.json(); // Parsing JSON response
        displayItems(hygieneItems, 'hygiene'); // Calling function to display hygiene items
    } catch (error) {
        console.error('Error fetching hygiene items:', error); // Logging errors to console
        document.getElementById('items').innerHTML = '<p>Error fetching hygiene items. Please try again later.</p>'; // Display error message
    }
}


// Function to display items on the page
function displayItems(items, type) {
    const itemsContainer = document.getElementById('items'); // Getting the container element
    itemsContainer.innerHTML = ''; // Clearing any existing content


    const imageUrls = { // Mapping item types to image URLs
        clothing: [
            'https://img.freepik.com/premium-photo/collection-men-s-clothing-including-jacket-pants-hat_793585-43.jpg',  // T-Shirt
            'https://img.freepik.com/premium-photo/collection-men-s-clothing-including-jacket-pants-hat_793585-43.jpg',  // Jeans
            'https://img.freepik.com/premium-photo/collection-men-s-clothing-including-jacket-pants-hat_793585-43.jpg',  // Jacket
            'https://img.freepik.com/premium-photo/collection-men-s-clothing-including-jacket-pants-hat_793585-43.jpg',  // Sweater
            'https://img.freepik.com/premium-photo/collection-men-s-clothing-including-jacket-pants-hat_793585-43.jpg'  // Shorts
        ],
        shoes: [
            'https://d1fufvy4xao6k9.cloudfront.net/images/blog/posts/2023/09/hockerty_wedding_groom_shoes_1e8487ba_9806_4fd7_9156_3f0498adefe9.jpg',  // Sneakers
            'https://d1fufvy4xao6k9.cloudfront.net/images/blog/posts/2023/09/hockerty_wedding_groom_shoes_1e8487ba_9806_4fd7_9156_3f0498adefe9.jpg',  // Boots
            'https://d1fufvy4xao6k9.cloudfront.net/images/blog/posts/2023/09/hockerty_wedding_groom_shoes_1e8487ba_9806_4fd7_9156_3f0498adefe9.jpg',  // Sandals
            'https://d1fufvy4xao6k9.cloudfront.net/images/blog/posts/2023/09/hockerty_wedding_groom_shoes_1e8487ba_9806_4fd7_9156_3f0498adefe9.jpg',  // Loafers
            'https://d1fufvy4xao6k9.cloudfront.net/images/blog/posts/2023/09/hockerty_wedding_groom_shoes_1e8487ba_9806_4fd7_9156_3f0498adefe9.jpg'  // Running Shoes
        ],
        hygiene: [
            'https://healthcompassng.com/rdscn/uploads/2023/05/personal_hygeine_hero.jpg',
            'https://healthcompassng.com/rdscn/uploads/2023/05/personal_hygeine_hero.jpg', 
            'https://healthcompassng.com/rdscn/uploads/2023/05/personal_hygeine_hero.jpg',  
            'https://healthcompassng.com/rdscn/uploads/2023/05/personal_hygeine_hero.jpg', 
            'https://healthcompassng.com/rdscn/uploads/2023/05/personal_hygeine_hero.jpg'  
        ]
    };


    items.forEach(item => { // Iterating over each item in the array
        const itemDiv = document.createElement('div'); // Creating a new div for each item
        itemDiv.classList.add('item'); // Adding class for styling
       
        // Adding item details and image to the div
        itemDiv.innerHTML = `
            <img src="${imageUrls[type]}" alt="${item.name}" /> <!-- Displaying item image -->
            <h3>${item.name}</h3> <!-- Displaying item name -->
            <p>${item.description}</p> <!-- Displaying item description -->
            <p>Price: $${item.price.toFixed(2)}</p> <!-- Displaying item price -->
            <button onclick="addToCart(${item.id})">Add to Cart</button> <!-- Button to add item to cart -->
        `;
       
        itemsContainer.appendChild(itemDiv); // Appending item div to the container
    });
}


// Function to handle adding an item to the cart (placeholder)
function addToCart(itemId) {
    alert(`Item ${itemId} added to cart!`); // Alert message for demonstration purposes
}


