document.addEventListener('DOMContentLoaded', (event) => {
    console.log('DOM fully loaded and parsed');

    const nutritionDiv = document.querySelector('.nutrition');
    nutritionDiv.style.transition = "opacity 0.3s ease";

    const toggleButton = document.createElement('button');
    toggleButton.textContent = "Toggle Nutrition Info";
    toggleButton.classList.add('toggleButton');



    toggleButton.addEventListener('click', () => {
        if (nutritionDiv.style.opacity !== '0') {
            nutritionDiv.style.opacity = '0';
            setTimeout(() => {
                nutritionDiv.style.display = 'none';
            }, 300);
            toggleButton.textContent = "Show Nutrition Info";
        } else {
            nutritionDiv.style.display = 'block';
            setTimeout(() => {
                nutritionDiv.style.opacity = '1';
            }, 10);
            toggleButton.textContent = "Hide Nutrition Info";
        }
    });

    document.querySelector('.container').appendChild(toggleButton);
});

function goBack() {
    window.history.back();
}

