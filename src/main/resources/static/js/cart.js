function addToCart(contentOfferingId) {
    fetch('/api/cart/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            contentOfferingId: contentOfferingId,
            quantity: 1
        }),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        alert('Item added to cart');
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

function removeFromCart(cartItemId) {
    fetch(`/api/cart/remove/${cartItemId}`, {
        method: 'DELETE',
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        alert('Item removed from cart');
        location.reload();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
