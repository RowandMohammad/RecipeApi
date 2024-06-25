document.addEventListener('DOMContentLoaded', (event) => {
    console.log('DOM fully loaded and parsed');

    // Let's add functionality to toggle the visibility of the nutrition info
    const nutritionDiv = document.querySelector('.nutrition');
    const toggleButton = document.createElement('button');
    toggleButton.textContent = "Toggle Nutrition Info";
    toggleButton.classList.add('toggleButton');

    toggleButton.addEventListener('click', () => {
        if (nutritionDiv.style.display === 'none') {
            nutritionDiv.style.display = 'block';
            toggleButton.textContent = "Hide Nutrition Info";
        } else {
            nutritionDiv.style.display = 'none';
            toggleButton.textContent = "Show Nutrition Info";
        }
    });

    document.querySelector('.container').appendChild(toggleButton);
});
